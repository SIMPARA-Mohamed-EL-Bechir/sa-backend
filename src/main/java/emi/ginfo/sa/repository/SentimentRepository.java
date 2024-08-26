package emi.ginfo.sa.repository;

import emi.ginfo.sa.entity.Sentiment;
import emi.ginfo.sa.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {

    List<Sentiment> findByType(TypeSentiment type);
}
