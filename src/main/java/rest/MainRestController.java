package rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractMap;
import java.util.HashMap;


@RestController
@RequestMapping(value = "/wordanalyzer")
public class MainRestController {
    //Игошев Константин
    //Номер телефона: 89101572838
    //Адрес эл. почты: leader_trident@mail.ru
    
    @RequestMapping("/analyze/{word}")
    public AbstractMap.SimpleEntry<Character, Integer> showNew(@PathVariable("word") String word) {
        return parseString(word);
    }

    public AbstractMap.SimpleEntry<Character, Integer> parseString(String s) {
        char maxCharacter = '\0';
        int maxCount = 0;
        int count = 0;
        HashMap<Character, Integer> hashmap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (hashmap.containsKey(ch)) {
                count = hashmap.get(ch);
                count++;
                hashmap.put(ch, (count));
                if (maxCount <= count) {
                    maxCount = count;
                    maxCharacter = ch;
                }
            } else {
                hashmap.put(ch, 1);
            }
        }
        return new AbstractMap.SimpleEntry<>(maxCharacter, maxCount);
    }
}
