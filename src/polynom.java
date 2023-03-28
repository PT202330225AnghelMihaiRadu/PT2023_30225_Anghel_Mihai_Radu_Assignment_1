import java.text.DecimalFormat;
import java.util.Collections;
import java.util.regex.*;
import java.util.Map;
import java.util.TreeMap;
public class polynom {
    public Map<Integer, Double> mapa = new TreeMap<>(Collections.reverseOrder());

    public polynom(String pol) {
        Pattern pattern = Pattern.compile("([-+^]?\\d+)|([-+]?[x])");
        Matcher matcher = pattern.matcher(pol);
        int x=0;
        int exp = 0;
        int xgas = 0;
        double coef = 0;
        while (matcher.find()) {
            if(matcher.group(1) == null){
                xgas = 1;
                String s2 = matcher.group(2);
               if(x == 0 && s2.charAt(0) == '+'){ coef = 1.0;x++;}
               else if(x == 0 && s2.charAt(0) == '-'){ coef = -1.0;x++;}
               else if(x == 0){coef = 1.0;x++;}
            }
            else{
                String s = matcher.group(1);
                 if (s.charAt(0) == '^') {
                    String str = s.substring(1);
                    exp = Integer.parseInt(str);
                    this.mapa.put(exp,coef);
                    x=0;
                    xgas = 0;
                    coef = 0;
                }else {
                     if(x == 1){
                         this.mapa.put(1, coef);
                         x = 0;
                         xgas = 0;
                     }
                     coef = Double.parseDouble(s);
                     x++;
                 }
            }
        }
        if(x != 0 && xgas == 0) this.mapa.put(0,coef);
        else this.mapa.put(1,coef);
    }

    public String toString(){
        String s = "";
        int x = 0;
        for (Map.Entry<Integer, Double> entry : this.mapa.entrySet()) {
            int key = entry.getKey();
            double value = entry.getValue();
            DecimalFormat df;
            df = new DecimalFormat("#.##");
            value = Double.valueOf(df.format(value));
            if(value != 0){
            if(key > 1){
                if(value == -1.0){
                    s = s + "-x^" + key;
                    x++;
                }
                else if(value == 1.0){
                    if(x==0){
                        s = s + "x^" + key;
                        x++;
                    }
                    else {
                        s = s + "+x^" + key;
                        x++;
                    }
                }
                else if(value < 0.0 || x == 0){
                    s = s + value + "x^" + key;
                    x++;
                }
                else s = s + "+" + value + "x^" + key;

            }
            if(key == 1){
                if(value == 1.0){
                    s = s + "+x";
                    x++;
                }
                else if(value == -1.0){
                    s = s + "-x";
                    x++;
                }
                else if(value < 0.0 || x == 0){
                    s = s + value + "x";
                    x++;
                }
                else s = s + "+" + value + "x";
            }
            if(key == 0){
                if(value < 0.0 || x == 0){
                    s = s + value;
                    x++;
                }
                else s = s + "+" + value;
            }
            }
        }
        return s;
    }

    public polynom adunare(polynom pol){
        for (Map.Entry<Integer, Double> entry : pol.mapa.entrySet()) {
            int key = entry.getKey();
            double value = entry.getValue();
            if(this.mapa.containsKey(key)){
                this.mapa.put(key, value + this.mapa.get(key));
            }
            else this.mapa.put(key, value);
        }
        return this;
    }

    public polynom scadere(polynom pol){
        for (Map.Entry<Integer, Double> entry : pol.mapa.entrySet()) {
            int key = entry.getKey();
            double value = entry.getValue();
            if(this.mapa.containsKey(key)){
                this.mapa.put(key, this.mapa.get(key) - value);
            }
            else this.mapa.put(key, 0.0 - value);
        }
        return this;
    }

    public polynom derivare(){
        polynom rezultat = new polynom("");
        for (Map.Entry<Integer, Double> entry : this.mapa.entrySet()) {
            int key = entry.getKey();
            double value = entry.getValue();
            if(key == 1){
                rezultat.mapa.put(0, value);
            }
            else if(key != 0){
                rezultat.mapa.put(key-1, value * key);
            }
        }
        return rezultat;
    }

    public polynom integrare(){
        polynom rezultat = new polynom("");
        for (Map.Entry<Integer, Double> entry : this.mapa.entrySet()) {
            int key = entry.getKey();
            double value = entry.getValue();
            if(key == 0) rezultat.mapa.put(1, value);
            else rezultat.mapa.put(key + 1, value/(key+1));
        }
        return rezultat;
    }

    public polynom inmultire(polynom pol){
        polynom rezultat = new polynom("");
        for (Map.Entry<Integer, Double> entry : pol.mapa.entrySet()) {
            int key1 = entry.getKey();
            double value1 = entry.getValue();
            for (Map.Entry<Integer, Double> entry1 : this.mapa.entrySet()) {
                int key2 = entry1.getKey();
                double value2 = entry1.getValue();
                if(rezultat.mapa.get(key1 + key2) != null){
                    rezultat.mapa.put(key1 + key2, rezultat.mapa.get(key1 + key2) + value1 * value2);
                }
                else rezultat.mapa.put(key1 + key2, value1 * value2);
            }
        }
        return rezultat;
    }
}
