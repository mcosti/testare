package pachet1;

public class Permutation {
    public static void main(String[] args)
    {
        String str = "ABCDEF";
        Permutation permutation = new Permutation();
        System.out.println(permutation.permute(str, 100));
    }

    public String permute(String str, int times) {
        if(times < 1 || times > 100) {
            throw new IllegalArgumentException("times should be between 1 and 100");
        }

        if(str.length() == 0) {
            throw new IllegalArgumentException("String should not be empty");
        }

        if(str.length() > 100) {
            throw new IllegalArgumentException("String should have maximum 100 chars.");
        }

        if (times % 2 == 0) {
            return permute_right(str, times);
        }
        else {
            return permute_left(str, times);
        }
    }

    private String permute_left(String str, int times){
        char[] stringChars = str.toCharArray();

        for (int i = 0; i < times; i++) {
            char first = stringChars[0];
            for(int j = 1; j < stringChars.length; j++) {
                stringChars[j - 1] = stringChars[j];
            }
            stringChars[stringChars.length - 1] = first;
        }

        return String.valueOf(stringChars);
    }

    private String permute_right(String str, int times){
        char[] stringChars = str.toCharArray();

        for (int i = 0; i < times; i++) {
            char last = stringChars[stringChars.length - 1];
            for(int j = stringChars.length - 2; j >= 0; j--) {
                stringChars[j + 1] = stringChars[j];
            }
            stringChars[0] = last;
        }

        return String.valueOf(stringChars);
    }




}
