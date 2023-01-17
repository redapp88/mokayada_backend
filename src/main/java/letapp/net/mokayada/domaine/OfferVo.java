package letapp.net.mokayada.domaine;

import java.util.Date;
import java.util.List;
import lombok.Data;
@Data
public class OfferVo {

	private Long id;
	private String title;
	private String description;
	private Date CreationDate;
	private List<ProductVo> products;
	private AppUserVo user;
	private List<ProposalVo> proposales;
	private DealVo deal;
}
