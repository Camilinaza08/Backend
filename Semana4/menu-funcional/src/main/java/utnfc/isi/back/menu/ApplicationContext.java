package utnfc.isi.back.menu;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ApplicationContext {

    private final Map<String, Object> store = new ConcurrentHashMap<>();

    // Singleton lazy holder
    private ApplicationContext() {}

    private static class Holder {
        private static final ApplicationContext INSTANCE = new ApplicationContext();
    }

    public static ApplicationContext getInstance() {
        return Holder.INSTANCE;
    }

    // ✅ put: inserta o actualiza
    public void put(String key, Object value) {
        store.put(key, value);
    }

    // ✅ get: valor bruto
    public Object get(String key) {
        return store.get(key);
    }

    // ✅ get con cast centralizado
    public <T> T get(String key, Class<T> type) {
        Object value = store.get(key);
        if (value == null) return null;
        if (!type.isInstance(value)) {
            throw new ClassCastException("El objeto bajo la clave '" + key + "' no es de tipo " + type.getName());
        }
        return type.cast(value);
    }

    // ✅ remove
    public void remove(String key) {
        store.remove(key);
    }

    // ✅ contains
    public boolean contains(String key) {
        return store.containsKey(key);
    }

    // ✅ set: solo reemplaza si existe
    public void set(String key, Object newValue) {
        if (!store.containsKey(key)) {
            throw new NoSuchElementException("No existe la clave '" + key + "' en el registro.");
        }
        store.put(key, newValue);
    }
}
