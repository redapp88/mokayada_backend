package letapp.net.mokayada.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import letapp.net.mokayada.entities.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {

}
