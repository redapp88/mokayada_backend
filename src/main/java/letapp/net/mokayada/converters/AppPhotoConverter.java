package letapp.net.mokayada.converters;

import java.util.ArrayList;
import java.util.List;

import letapp.net.mokayada.domaine.AppPhotoVo;
import letapp.net.mokayada.entities.AppPhoto;

public class AppPhotoConverter {
	public static AppPhotoVo toVo(AppPhoto bo) {
		AppPhotoVo vo = new AppPhotoVo();
		vo.setId(bo.getId());
		vo.setDescription(bo.getDescription());
		vo.setUrl(bo.getUrl());
		return vo;
	}

	public static AppPhoto toBo(AppPhotoVo vo) {
		AppPhoto bo = new AppPhoto();
		bo.setId(vo.getId());
		bo.setDescription(vo.getDescription());
		bo.setUrl(vo.getUrl());
		return bo;
	}

	public static List<AppPhotoVo> toListVo(List<AppPhoto> listBo) {
		List<AppPhotoVo> listVo = new ArrayList<AppPhotoVo>();
		listBo.forEach(bo -> {
			listVo.add(toVo(bo));
		});
		return listVo;

	}

	public static List<AppPhoto> toListBo(List<AppPhotoVo> listVo) {
		List<AppPhoto> listBo = new ArrayList<AppPhoto>();
		listVo.forEach(vo -> {
			listBo.add(toBo(vo));
		});
		return listBo;

	}
}
