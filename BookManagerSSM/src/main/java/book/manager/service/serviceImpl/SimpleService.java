package book.manager.service.serviceImpl;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleService {

    @PostFilter("filterObject.equals('Acheron')")
    public List<String> test() {
        List<String> list = new ArrayList<>();
        list.add("Elysia");
        list.add("Acheron");
        return list;
    }
}
