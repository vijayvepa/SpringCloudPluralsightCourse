using System;

namespace TollRateClient
{
    public class FeignClientAttribute : Attribute
    {
        public string Name { get; private set; }
        
        public FeignClientAttribute(string name)
        {
            Name = name;
        }
    }
}