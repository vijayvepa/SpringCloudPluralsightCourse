using System;
using Microsoft.AspNetCore.Mvc.RazorPages;
using TollRateClient;

namespace TollRateBillboard.Pages
{
    public class DashboardModel: PageModel
    {
        private ITollRateServiceContract _contract;
        
        public DashboardModel(ITollRateServiceContract contract)
        {
            this._contract = contract;
        }
        
        public decimal Rate { get; set; }
        
        public int StationId { get; set; }

        public async void OnGetAsync(int stationId)
        {
             var rate = await _contract.GetTollRate(stationId);
            Rate = rate.CurrentRate;

        }
    }
}