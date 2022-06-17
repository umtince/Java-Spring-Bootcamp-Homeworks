package com.mobileactionbootcamp.uincehw2.gen.service;

import com.mobileactionbootcamp.uincehw2.adr.dao.AdrAddressDao;
import com.mobileactionbootcamp.uincehw2.cnt.dao.CntCountryDao;
import com.mobileactionbootcamp.uincehw2.cnt.entity.CntCountry;
import com.mobileactionbootcamp.uincehw2.cty.dao.CtyCityDao;
import com.mobileactionbootcamp.uincehw2.cty.entity.CtyCity;
import com.mobileactionbootcamp.uincehw2.dst.dao.DstDistrictDao;
import com.mobileactionbootcamp.uincehw2.dst.entity.DstDistrict;
import com.mobileactionbootcamp.uincehw2.nei.dao.NeiNeighborhoodDao;
import com.mobileactionbootcamp.uincehw2.nei.entity.NeiNeighborhood;
import com.mobileactionbootcamp.uincehw2.str.dao.StrStreetDao;
import com.mobileactionbootcamp.uincehw2.str.entity.StrStreet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class GenGeneralService {

    private CntCountryDao cntCountryDao;
    private CtyCityDao ctyCityDao;
    private DstDistrictDao dstDistrictDao;
    private NeiNeighborhoodDao neiNeighborhoodDao;
    private StrStreetDao strStreetDao;
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * These findInDBAndAssignIds functions are chained together to prevent
     * duplicate entries in the database. If the entity is a persisting object
     * (meaning objects that are already in the database) new object is merged with
     * persisting object using EntityManager#merge method.
     *
     * Respective services from different entities call different levels of these
     * chained methods.
     *
     * AdrAddressService calls the findInDBAndAssignIds(StrStreet) method because
     * the address entity has every entites in it, so it must call the top method
     * on the chain.
     * */


    public StrStreet findInDBAndAssignIds(StrStreet strStreet){
        List<StrStreet> strStreetList = strStreetDao.findAll();

        for(StrStreet street : strStreetList){
            if(street.getStreetName().equals(strStreet.getStreetName())){
                strStreet.setId(street.getId());
            }
        }

        strStreet.setNeighborhood(findInDBAndAssignIds(strStreet.getNeighborhood()));
        if(strStreet.getId() == null){
            if(strStreet.getNeighborhood().getId() != null){
                strStreet = entityManager.merge(strStreet);
            }
        }

        return strStreet;
    }
    public NeiNeighborhood findInDBAndAssignIds(NeiNeighborhood neiNeighborhood){
        List<NeiNeighborhood> neiNeighborhoodList = neiNeighborhoodDao.findAll();

        for(NeiNeighborhood neighborhood : neiNeighborhoodList){
            if(neighborhood.getNeighborhoodName().equals(neiNeighborhood.getNeighborhoodName())){
                neiNeighborhood.setId(neighborhood.getId());
            }
        }

        neiNeighborhood.setDistrict(findInDBAndAssignIds(neiNeighborhood.getDistrict()));
        if(neiNeighborhood.getId() == null){
            if(neiNeighborhood.getDistrict().getId() != null){
                neiNeighborhood = entityManager.merge(neiNeighborhood);
            }
        }
        return neiNeighborhood;
    }

    public DstDistrict findInDBAndAssignIds(DstDistrict dstDistrict){
        List<DstDistrict> dstDistrictList = dstDistrictDao.findAll();

        for(DstDistrict district : dstDistrictList){
            if(district.getDistrictName().equals(dstDistrict.getDistrictName())){
                dstDistrict.setId(district.getId());
            }
        }

        dstDistrict.setCity(findInDBAndAssignIds(dstDistrict.getCity()));
        if (dstDistrict.getId() == null){
            if (dstDistrict.getCity().getId() != null){
                dstDistrict = entityManager.merge(dstDistrict);
            }
        }

        return dstDistrict;
    }

    public CtyCity findInDBAndAssignIds(CtyCity ctyCity){
        List<CtyCity> ctyCityList = ctyCityDao.findAll();

        for(CtyCity city : ctyCityList){
            if(city.getCityName().equals(ctyCity.getCityName())){
                ctyCity.setId(city.getId());
            }
        }

        ctyCity.setCountry(findInDBAndAssignIds(ctyCity.getCountry()));
        if(ctyCity.getId() == null){
            if(ctyCity.getCountry().getId() != null){
                ctyCity = entityManager.merge(ctyCity);
            }
        }

        return ctyCity;
    }

    public CntCountry findInDBAndAssignIds(CntCountry cntCountry){
        List<CntCountry> cntCountryList = cntCountryDao.findAll();

        for(CntCountry country : cntCountryList){
            if(country.getCountryName().equals(cntCountry.getCountryName())){
                cntCountry.setId(country.getId());
            }
        }
        return cntCountry;
    }
}
