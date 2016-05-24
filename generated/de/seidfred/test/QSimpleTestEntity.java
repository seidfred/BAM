package de.seidfred.test;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSimpleTestEntity is a Querydsl query type for SimpleTestEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSimpleTestEntity extends EntityPathBase<SimpleTestEntity> {

    private static final long serialVersionUID = -404886310L;

    public static final QSimpleTestEntity simpleTestEntity = new QSimpleTestEntity("simpleTestEntity");

    public final NumberPath<java.math.BigDecimal> bigDecimal = createNumber("bigDecimal", java.math.BigDecimal.class);

    public final NumberPath<Double> doubleWrap = createNumber("doubleWrap", Double.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> integerWrap = createNumber("integerWrap", Integer.class);

    public final NumberPath<Short> shortWrap = createNumber("shortWrap", Short.class);

    public final StringPath string = createString("string");

    public QSimpleTestEntity(String variable) {
        super(SimpleTestEntity.class,  forVariable(variable));
    }

    public QSimpleTestEntity(Path<? extends SimpleTestEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSimpleTestEntity(PathMetadata<?> metadata) {
        super(SimpleTestEntity.class,  metadata);
    }

}

