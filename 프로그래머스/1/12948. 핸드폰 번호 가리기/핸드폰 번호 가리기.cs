using System.Linq;
public class Solution {
    public string solution(string phone_number) {
       // return phone_number.Substring(phone_number.Length-4).PadLeft(phone_number.Length, '*');
        // return new string(phone_number.Select((s,i) => i<phone_number.Length-4?'*':s).ToArray());
        return phone_number.Substring(phone_number.Length-4).PadLeft(phone_number.Length, '*');
    }
}