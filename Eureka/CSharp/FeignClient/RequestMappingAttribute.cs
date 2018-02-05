using System;

namespace TollRateClient
{
    public class RequestMappingAttribute : Attribute
    {
        public RequestMethod Method { get; set; }

        public string Path { get; set; }
    }
}