class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        char ch[] = s.toCharArray();
        int sum =0;
        int point = 0;
        for(int i =0;i<ch.length;i++){
            while(point<ch.length){
               if(point < ch.length-1 && map.get(ch[point]) < map.get(ch[point+1])){
                    sum -= map.get(ch[point]);   
                }else{
                    sum += map.get(ch[point]); 
                }
                point++;
            }
        }
        return sum;
    }
}