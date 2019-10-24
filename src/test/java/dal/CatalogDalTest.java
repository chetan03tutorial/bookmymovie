package dal;

/*import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;*/


/*@RunWith(SpringRunner.class)
@SpringBootTest(classes=DbConfig.class)
@EnableTransactionManagement*/
public class CatalogDalTest {

    /*@Autowired
    private CatalogDAL catalogDal;


    @Test
    @Transactional("catalogTransactionManager")
    public void whenCreatingUser_thenCreated() {
        CatalogInfo catalog = new CatalogInfo();
        catalog.setDirector("Director");
        catalog.setName("MovieName");
        CatalogInfo catalogInfo = catalogDal.save(catalog);



        Optional<CatalogInfo> catalogInfo2 = catalogDal.findById(catalogInfo.getId());

        if(catalogInfo2.isPresent()){
            System.out.println("Object is available in DB");
            System.out.println(catalogInfo2.get().getDirector());
        }else{
            System.out.println("Not present in the database");
        }
        catalogInfo.setDirector("Director2");
        System.out.println(catalogInfo2.get().getDirector());

    }*/


}
