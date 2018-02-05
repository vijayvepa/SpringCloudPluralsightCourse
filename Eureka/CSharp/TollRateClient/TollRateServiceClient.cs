using System.Net.Http;
using System.Runtime.InteropServices;
using System.Security.Cryptography;
using System.Threading.Tasks;
using Microsoft.Extensions.Logging;
using Newtonsoft.Json;
using Steeltoe.Common.Discovery;

namespace TollRateClient
{
    public class TollRateServiceClient : ITollRateServiceContract
    {
        private DiscoveryHttpClientHandler Handler { get; set; }

        private ILogger<TollRateServiceClient> Logger { get; set; }
        
        public TollRateServiceClient(IDiscoveryClient client, ILoggerFactory factory)
        {
            Handler = new DiscoveryHttpClientHandler(client, factory.CreateLogger<DiscoveryHttpClientHandler>());
            this.Factory = factory;
            Logger = factory.CreateLogger<TollRateServiceClient>();
        }

        public ILoggerFactory Factory { get; set; }

        public IDiscoveryClient Client { get; set; }

        public async Task<TollRate> GetTollRate(int stationId)
        {
            var client = new HttpClient(Handler, false);

            var tollRate = await client.GetStringAsync("http://" + TollRateServiceInfo.Name + "/tollrate/" + stationId);

            var result= JsonConvert.DeserializeObject<TollRate>(tollRate);
            return result;
        }
        
    }
}