package iobserver;

public interface IObserver {
	void addObserver(IListener listener); //we add another subscriber
    void removeObserver(IListener listener); //we remove subscriber
    void notifyObservers(Object event); //we notify all subscribers about change
}
