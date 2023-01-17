package letapp.net.mokayada.domaine;

import java.util.Date;
import java.util.List;

import letapp.net.mokayada.entities.AppRole;
import lombok.Data;

@Data
public class AppUserVo {

	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String sex;
	private String phone;
	private String birthDate;
	private String localisation;
	private Date subscribeDate;
	private List<OfferVo> offers;
	private AppRole appRoleVo;
	private List<ProposalVo> proposales;
}
