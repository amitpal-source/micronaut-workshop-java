package clubs.domain;

import javax.transaction.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

import io.micronaut.data.annotation.*;

//tag::class[]
@Singleton
//@Repository
public class ClubRepositoryImpl implements ClubRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Long count() {
        return entityManager.createQuery("select count(c) from Club c", Long.class).getSingleResult();
    }

    @Override
    @Transactional
    public Club save(@NotBlank String name, String stadium) {
        Club club = new Club(name);
        club.setStadium(stadium);
        entityManager.persist(club);
        return club;
    }

    @Override
    @Transactional
    public List<Club> findAll() {
        return entityManager.createQuery("select c from Club c", Club.class).getResultList();
    }

    @Override
    @Transactional
    public Optional<Club> find(@NotNull Long id) {
        return Optional.ofNullable(entityManager.find(Club.class, id));
    }

}
//end::class[]

