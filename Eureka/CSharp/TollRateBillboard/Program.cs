using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Hosting;
using Microsoft.CodeAnalysis.CSharp.Syntax;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Logging;

namespace TollRateBillboard
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var hostName = Dns.GetHostName();
           // Console.WriteLine(Dns.GetHostAddresses(hostName));

            BuildWebHost(args).Run();
        }

        public static IWebHost BuildWebHost(string[] args) =>
            
            WebHost.CreateDefaultBuilder(args)
                .UseStartup<Startup>()
                .Build();
    }
}