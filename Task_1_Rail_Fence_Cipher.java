package Ready;

// Task 1. Rail Fence Cipher. Encoding and Decoding
public class RailFenceCipher {

    int rails;

    RailFenceCipher(int rails){
        this.rails = rails;
    }

    static String encode(String input, int rails) {

        int len = input.length();
        StringBuilder sb = new StringBuilder(len);

        int stepDown = 2*(rails-1);
        int stepUp = 0;

        for(int rail=0; rail<rails; rail++){
            sb.append(input.charAt(rail));
            for(int i=rail; i<len;){
                i += stepDown;
                if(stepDown>0 && i<len){
                    sb.append(input.charAt(i));
                }
                i += stepUp;
                if(stepUp>0 && i<len){
                    sb.append(input.charAt(i));
                }
            }
            stepUp += 2;
            stepDown -=2;
        }
        return sb.toString();
    }

    static String decode(String input, int rails) {

        int len = input.length();
        StringBuilder sb = new StringBuilder(input);

        int stepDown = 2*(rails-1);
        int stepUp = 0;

        int pos = 0;

        for(int rail = 0; rail<rails; rail++){
            sb.setCharAt(rail, input.charAt(pos++));
            for(int i=rail; i<len;){
                i += stepDown;
                if(stepDown>0 && i<len){
                    sb.setCharAt(i, input.charAt(pos++));
                }
                i += stepUp;
                if(stepUp>0 && i<len){
                    sb.setCharAt(i, input.charAt(pos++));
                }
            }
            stepUp += 2;
            stepDown -=2;
        }
        return sb.toString();
    }
}
