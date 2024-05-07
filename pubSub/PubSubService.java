import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PubSubService {
    private Map<String, List<Subscriber>> subscribersTopicMap = new HashMap<>();

    public void subscribe(String topic, Subscriber subscriber) {
        subscribersTopicMap.computeIfAbsent(topic, k -> new ArrayList<>()).add(subscriber);
    }

    public void publish(Message message) {
        List<Subscriber> subscribers = subscribersTopicMap.get(message.getTopic());
        if (subscribers != null) {
            for (Subscriber subscriber : subscribers) {
                subscriber.receive(message);
            }
        }
    }
}
