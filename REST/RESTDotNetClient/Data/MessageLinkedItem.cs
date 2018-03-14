using System.Runtime.Serialization;

namespace DotNetClient.Data
{
    [DataContract]
    public class MessageLinkedItem
    {
        [DataMember]
        public string item { get; set; }
    }
}