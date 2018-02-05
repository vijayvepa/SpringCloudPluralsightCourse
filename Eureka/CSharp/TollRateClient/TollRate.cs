namespace TollRateClient
{
    public class TollRate
    {
        public int StationId { get; set; }
        
        public decimal CurrentRate { get; set; }
        
        public string TimeStamp { get; set; }
    }
}