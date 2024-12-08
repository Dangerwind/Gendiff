package hexlet.code;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static hexlet.code.Utilites.Stat;

public final class OutData {
    @Getter
    private int length;
    private final List<Stat> status = new ArrayList<>();
    private final List<String> key = new ArrayList<>();
    private final List<Object> value = new ArrayList<>();
    public void outData() {
        length = 0;
    }
    public void add(Stat newStatus, String newKey, Object newValue) {
        status.add(newStatus);
        key.add(newKey);
        value.add(newValue);
        length++;
    }
    public  String getKey(int index) {
        return key.get(index);
    }
    public  Object getValue(int index) {
        return value.get(index);
    }
    public  Stat getStatus(int index) {
        return status.get(index);
    }
}
