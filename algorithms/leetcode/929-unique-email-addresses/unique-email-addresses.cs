public class Solution {
    public int NumUniqueEmails(string[] emails) {
        var hash = new HashSet<string>();
        
        foreach (string email in emails) {
            StringBuilder sb = new StringBuilder();
            
            bool flag = false;
            
            int i;
            
            for (i = 0; i < email.Length; i++) {
                var ch = email[i];
                
                if (ch == '+') flag = true;
                if (ch == '@') break;
                if (ch == '.') continue;
                
                if (!flag) sb.Append(ch);
            }
            
            for (; i < email.Length; i++) {
                sb.Append(email[i]);
            }
            
            hash.Add(sb.ToString());
        }
        
        return hash.Count;
    }
}
