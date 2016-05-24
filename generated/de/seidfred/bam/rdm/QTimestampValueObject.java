package de.seidfred.bam.rdm;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTimestampValueObject is a Querydsl query type for TimestampValueObject
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QTimestampValueObject extends BeanPath<TimestampValueObject> {

    private static final long serialVersionUID = -262207914L;

    public static final QTimestampValueObject timestampValueObject = new QTimestampValueObject("timestampValueObject");

    public final QAbstractSimpleValueObject _super = new QAbstractSimpleValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    public final DateTimePath<java.util.Date> value = createDateTime("value", java.util.Date.class);

    public QTimestampValueObject(String variable) {
        super(TimestampValueObject.class,  forVariable(variable));
    }

    public QTimestampValueObject(Path<? extends TimestampValueObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTimestampValueObject(PathMetadata<?> metadata) {
        super(TimestampValueObject.class,  metadata);
    }

}

