class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int nameLen = name.length();
        int typedLen = typed.length();
        
        int nameIdx = 0, typedIdx = 0;
        for (; nameIdx < nameLen && typedIdx < typedLen; nameIdx++, typedIdx++) {
            char ch = name.charAt(nameIdx);
            char tch = typed.charAt(typedIdx);
            
            if (ch != tch) {
                return false;
            }
            
            int curNameLen = 1;
            int curTypedLen = 1;
            
            while (nameIdx < (nameLen - 1) && name.charAt(nameIdx + 1) == ch) {
                curNameLen++;
                nameIdx++;
            }
            
            while (typedIdx < (typedLen - 1) && typed.charAt(typedIdx + 1) == tch) {
                curTypedLen++;
                typedIdx++;
            }
            
            if (curTypedLen < curNameLen) {
                return false;
            }
        }
        
        return typedIdx == typedLen && nameIdx == nameLen;
    }
}
