using System.IO;
using System.Threading.Tasks;

namespace TollRateClient
{
    [FeignClient("http://" + TollRateServiceInfo.Name)]
    public  interface ITollRateServiceContract
    {
        [RequestMapping(Method = RequestMethod.Get, Path = "tollrate/{stationId}")]
        Task<TollRate> GetTollRate([PathVariable("stationId")] int stationId);
    }
}