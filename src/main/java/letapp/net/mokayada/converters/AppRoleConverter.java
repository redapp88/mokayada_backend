package letapp.net.mokayada.converters;

import java.util.ArrayList;
import java.util.List;

import letapp.net.mokayada.domaine.AppRoleVo;
import letapp.net.mokayada.entities.AppRole;

public class AppRoleConverter {

	public static AppRoleVo toVo(AppRole bo) {
		AppRoleVo vo = new AppRoleVo();
		vo.setId(bo.getId());
		vo.setRoleName(bo.getRoleName());
		return vo;
	}

	public static AppRole toBo(AppRoleVo vo) {
		AppRole bo = new AppRole();
		bo.setId(vo.getId());
		bo.setRoleName(vo.getRoleName());
		return bo;
	}

	public static List<AppRoleVo> toListVo(List<AppRole> listBo) {
		List<AppRoleVo> listVo = new ArrayList<AppRoleVo>();
		listBo.forEach(bo -> {
			listVo.add(toVo(bo));
		});
		return listVo;

	}

	public static List<AppRole> toListBo(List<AppRoleVo> listVo) {
		List<AppRole> listBo = new ArrayList<AppRole>();
		listVo.forEach(vo -> {
			listBo.add(toBo(vo));
		});
		return listBo;

	}
}
