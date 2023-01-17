package letapp.net.mokayada.converters;

import java.util.ArrayList;
import java.util.List;

import letapp.net.mokayada.dao.ProposalRepository;
import letapp.net.mokayada.domaine.AppUserVo;
import letapp.net.mokayada.entities.AppUser;

public class AppUserConverter {
	public static AppUserVo toVo(AppUser bo) {
		AppUserVo vo = new AppUserVo();
		vo.setUsername(bo.getUsername());
		vo.setFirstName(bo.getFirstName());
		vo.setLastName(bo.getLastName());
		vo.setEmail(bo.getEmail());
		vo.setSex(bo.getSex());
		vo.setPhone(bo.getSex());
		vo.setBirthDate(bo.getBirthDate());
		vo.setLocalisation(bo.getLocalisation());
		vo.setSubscribeDate(bo.getSubscribeDate());
		vo.setOffers(OfferConverter.toListVo(bo.getOffers()));
		vo.setProposales(ProposalConverter.toListVo(bo.getProposales()));
		return vo;
	}

	public static AppUser toBo(AppUserVo vo) {
		AppUser bo = new AppUser();
		bo.setUsername(vo.getUsername());
		bo.setFirstName(vo.getFirstName());
		bo.setLastName(vo.getLastName());
		bo.setEmail(vo.getEmail());
		bo.setSex(vo.getSex());
		bo.setPhone(vo.getSex());
		bo.setBirthDate(vo.getBirthDate());
		bo.setLocalisation(vo.getLocalisation());
		bo.setSubscribeDate(vo.getSubscribeDate());
		bo.setOffers(OfferConverter.toListBo(vo.getOffers()));
		bo.setProposales(ProposalConverter.toListBo(vo.getProposales()));
		return bo;
	}

	public static List<AppUserVo> toListVo(List<AppUser> listBo) {
		List<AppUserVo> listVo = new ArrayList<AppUserVo>();
		listBo.forEach(bo -> {
			listVo.add(toVo(bo));
		});
		return listVo;

	}

	public static List<AppUser> toListBo(List<AppUserVo> listVo) {
		List<AppUser> listBo = new ArrayList<AppUser>();
		listVo.forEach(vo -> {
			listBo.add(toBo(vo));
		});
		return listBo;

	}

}
