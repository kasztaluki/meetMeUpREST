package pl.webdevchallenge.meetmeuprest.eventApp.repository;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryEventRepository {

//    protected final Map<Long, Event> map = new HashMap<>();
//    protected long counter = 1;
//
//    public Event save(Event entity) {
//        setData(entity);
//        return entity;
//    }
//
//    private Event setData(Event entity) {
//        if (entity.getId() != null) {
//            map.put(entity.getId(), entity);
//        }
//        else{
//            entity.setId(counter);
//            map.put(counter, entity);
//            counter++;
//        }
//        return entity;
//    }
//
//    public Optional<Event> findById(Long id) {
//        return Optional.ofNullable(map.get(id));
//    }
//
//    public List<Event> findAll() {
//        return new ArrayList<>(map.values());
//    }
//
//    public void deleteById(Long id) {
//        map.remove(id);
//    }
}
