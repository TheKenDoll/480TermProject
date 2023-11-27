package com.ensf480.backend.repositories;

<<<<<<< HEAD:backend/src/main/java/com/ensf480/backend/repositories/UserRepository.java
import org.springframework.stereotype.Repository;

import java.util.Optional;

=======
>>>>>>> e2ad682ec90fd7b3d50f3c8514d962be7746d4f9:backend/src/main/java/com/ensf480/backend/repositories/PilotRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensf480.backend.models.Pilot;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, Long> {

    Optional<User> findByEmail(String email);


    //Optional<User> existsByEmail(String email);
    //Boolean exitsByEmail(String email);


}
