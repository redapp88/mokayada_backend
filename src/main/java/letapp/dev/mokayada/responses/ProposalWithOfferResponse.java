package letapp.dev.mokayada.responses;

import letapp.dev.mokayada.entities.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProposalWithOfferResponse {
private Offer proposal;
private Offer offer;
}
