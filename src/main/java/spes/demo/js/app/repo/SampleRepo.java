package spes.demo.js.app.repo;

import org.springframework.data.repository.CrudRepository;
import spes.demo.js.app.entity.Sample;

public interface SampleRepo extends CrudRepository<Sample, Long> {
}
