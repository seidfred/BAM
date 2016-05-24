package de.seidfred.bam.rdm;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QShortValueObject is a Querydsl query type for ShortValueObject
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QShortValueObject extends BeanPath<ShortValueObject> {

    private static final long serialVersionUID = -193876688L;

    public static final QShortValueObject shortValueObject = new QShortValueObject("shortValueObject");

    public final QAbstractSimpleValueObject _super = new QAbstractSimpleValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    public final NumberPath<Short> value = createNumber("value", Short.class);

    public QShortValueObject(String variable) {
        super(ShortValueObject.class,  forVariable(variable));
    }

    public QShortValueObject(Path<? extends ShortValueObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShortValueObject(PathMetadata<?> metadata) {
        super(ShortValueObject.class,  metadata);
    }

}

