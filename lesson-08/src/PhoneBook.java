import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneBook {
    private final Map<String, List<String>> cotacts = new HashMap<>();

    public void add(String name, String phone) {
        if (cotacts.containsKey(name)) {
            cotacts.get(name).add(phone);
        } else {
            List<String> phones = new ArrayList<>();
            phones.add(phone);
            cotacts.put(name, phones);
        }
    }

    public List<String> get(String name) {
        return cotacts.getOrDefault(name, new ArrayList<>());
    }
}

