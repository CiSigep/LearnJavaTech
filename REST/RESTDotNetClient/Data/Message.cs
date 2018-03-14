using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace DotNetClient.Data
{
    [DataContract]
    class Message
    {
        [DataMember]
        public string msg { get; set; }

        [DataMember]
        public List<MessageLinkedItem> mli { get; set; }

    }
}
