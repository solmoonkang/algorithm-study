package observer;

public class ObserverApplication {

    public static void main(String[] args) {
        Topic topic = new Topic();

        Observer observerA = new TopicSubscriber("observerA", topic);
        Observer observerB = new TopicSubscriber("observerB", topic);
        Observer observerC = new TopicSubscriber("observerC", topic);

        topic.register(observerA);
        topic.register(observerB);
        topic.register(observerC);

        topic.postMessage("amumu is op champion!!");
    }
}
