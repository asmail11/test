package org.capiskinserver.domain.hair;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.generator.JavassistCompilerStrategy;
import ma.glasnost.orika.unenhance.HibernateUnenhanceStrategy;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class OrikaBeanMapper extends ConfigurableMapper {
    private MapperFactory factory;
    
    public OrikaBeanMapper() {
        super(false);
        init();
    }

 /**
 * {@inheritDoc}
 */

 @Override
 protected void configure(MapperFactory factory) {
    this.factory = factory;     

  }
 private void registerClassMap(final Class<?> a, final Class<?> b) {
     this.factory.classMap(a, b).mapNulls(true).mapNullsInReverse(true).byDefault().register();
 }
  
 /**
 * {@inheritDoc}
 */
 @Override
 protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) {
   factoryBuilder.compilerStrategy(new JavassistCompilerStrategy());
   factoryBuilder.unenhanceStrategy(new HibernateUnenhanceStrategy());
  } 
 
 /**
 * User Orika to convert entity => DTO / DTO => entity
 *
 * @param from
 * @param toClass
 * @param <T>
 * @param <U>     return
 */ 
 public <T, U> T convertDTO(U from, Class<T> toClass) {
     if (from == null) {
         return null;
     }
   return map(from, toClass);
 }
 
 /**
 * User Orika to convert entity => DTO / DTO => entity
 *
 * @param from
 * @param toClass
 * @param <T>
 * @param <U>
 * @return
 */
 public <T, U> List<T> convertListDTO(Iterable<U> from, Class<T> toClass) {
    if (from == null) {
       return null;
    }
    return mapAsList(from, toClass);
 }
 
 public <T, U> Page<T> convertPageDTO(Page<U> from, Class<T> toClass) {
    if (from == null) {
         return null;
    }
     return from.map(entity -> factory.getMapperFacade().map(entity, toClass));
  }
}
