package de.gtopcu.maps.extended;

import java.util.HashMap;
import java.util.Map;

public class TriggerMap<K, V extends Triggerable> extends HashMap<K, V> {
    private TriggerMapSettings settings;

    public void setSettings(TriggerMapSettings settings) {
        this.settings = settings;
    }

    @Override
    public V put(K key, V value) {
        if (settings == null) {
            return super.put(key, value);
        }
        if (settings.isOnBeforePut()) {
            value.doTrigger();
        }
        final V result = super.put(key, value);
        if (settings.isOnAfterPut()) {
            value.doTrigger();
        }
        return result;
    }

    @Override
    public V putIfAbsent(K key, V value) {
        if (settings == null) {
            return super.putIfAbsent(key, value);
        }
        if (settings.isOnBeforePut()) {
            value.doTrigger();
        }
        final V result = super.putIfAbsent(key, value);
        if (settings.isOnAfterPut()) {
            value.doTrigger();
        }
        return result;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> values) {
        if (settings == null) {
            super.putAll(values);
        }
        if (settings.isOnBeforePut()) {
            values.values().forEach(Triggerable::doTrigger);
        }
        super.putAll(values);
        if (settings.isOnAfterPut()) {
            values.values().forEach(Triggerable::doTrigger);
        }
    }

    @Override
    public V get(Object key) {
        final V value = super.get(key);
        if (settings != null && settings.isOnGet()) {
            value.doTrigger();
        }
        return value;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        final V value = super.getOrDefault(key, defaultValue);
        if (settings != null && settings.isOnGet()) {
            value.doTrigger();
        }
        return value;
    }
}
