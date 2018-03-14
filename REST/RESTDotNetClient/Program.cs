using DotNetClient.Data;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Runtime.Serialization.Json;
using System.Text;
using System.Threading.Tasks;

namespace DotNetClient
{
    class Program
    {
        static void Main(string[] args)
        {
            //Demonstrating a .NET client working with a Java Server
            DataContractJsonSerializer dcjs = new DataContractJsonSerializer(typeof(Message));

            WebRequest req = WebRequest.Create("http://localhost:7001/RESTServer/api");
            req.Method = "GET";
            req.ContentType = "application/json";
            WebResponse resp = req.GetResponse();

            Stream stm = resp.GetResponseStream();

            Message m = (Message) dcjs.ReadObject(stm);


            Console.WriteLine(m.msg);
            Console.WriteLine(m.mli[0].item);

            resp.Close();

            req = WebRequest.Create("http://localhost:7001/RESTServer/api");
            req.Method = "POST";
            req.ContentType = "application/json";

            Message sendM = new Message();
            sendM.msg = "DotNet";

            dcjs.WriteObject(req.GetRequestStream(), sendM);

            resp = req.GetResponse();

            stm = resp.GetResponseStream();

            m = (Message)dcjs.ReadObject(stm);


            Console.WriteLine(m.msg);
            Console.WriteLine(m.mli[0].item);
            Console.WriteLine(m.mli[1].item);

            resp.Close();


            Console.ReadLine(); // Pause for reading



        }
    }
}
