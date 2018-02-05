using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Runtime.CompilerServices;
using System.Threading.Tasks;
using Microsoft.Extensions.Logging;
using Newtonsoft.Json;
using Steeltoe.Common.Discovery;

namespace TollRateClient
{
    public class TollRateFeignClient : Feign<ITollRateServiceContract>, ITollRateServiceContract
    {
        public TollRateFeignClient(IDiscoveryClient client, ILoggerFactory factory) : base(client, factory)
        {
        }

        public async Task<TollRate> GetTollRate(int stationId)
        {
            var data = await GetDataAsync( parameters: new object[]{ stationId});
            return JsonConvert.DeserializeObject<TollRate>(data);
        }
    }

    public class Feign<T>
    {
        private DiscoveryHttpClientHandler Handler { get; set; }

        private ILogger<TollRateServiceClient> Logger { get; set; }
        
        private Dictionary<string, OperationInfo> Operations { get; set; }

        public Feign(IDiscoveryClient client, ILoggerFactory factory)
        {
            Handler = new DiscoveryHttpClientHandler(client, factory.CreateLogger<DiscoveryHttpClientHandler>());
            Logger = factory.CreateLogger<TollRateServiceClient>();

            Operations = BuildOperations();
        }

        private Dictionary<string, OperationInfo> BuildOperations()
        {
            var operations = new Dictionary<string, OperationInfo>();
            var type = Type.GetType(typeof(T).FullName);
            var methods = type.GetMethods();

            var nameAttribute = type.GetCustomAttributes(typeof(FeignClientAttribute), true);

            foreach (var method in methods)
            {
                var attributes = method.GetCustomAttributes(typeof(RequestMappingAttribute), true);

                if(!(attributes.FirstOrDefault() is RequestMappingAttribute requestMapping))
                      continue;
                
                
                if(!(nameAttribute.FirstOrDefault() is FeignClientAttribute feignClientAttribute))
                    continue;

                var info = new OperationInfo {RequestMapping = requestMapping, FeignClient = feignClientAttribute };

                operations.Add(method.Name, info);
            }

            return operations;
        }

        public async Task<string> GetDataAsync(  [CallerMemberName] string methodName = null, params object[] parameters)
        {
            var client = new HttpClient(Handler, false);

            var info = Operations[methodName];
            var path = info.RequestMapping.Path;

            path = path.Replace("{stationId}", parameters[0].ToString());
            
          
            
            return await client.GetStringAsync( info.FeignClient.Name + "/"+ path);
        }

        
    }

    public class OperationInfo
    {
        public FeignClientAttribute FeignClient { get; set; }
        public RequestMappingAttribute RequestMapping { get; set; }
    }
}