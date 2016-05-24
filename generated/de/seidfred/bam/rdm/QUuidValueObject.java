package de.seidfred.bam.rdm;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUuidValueObject is a Querydsl query type for UuidValueObject
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QUuidValueObject extends BeanPath<UuidValueObject> {

    private static final long serialVersionUID = 1695541913L;

    public static final QUuidValueObject uuidValueObject = new QUuidValueObject("uuidValueObject");

    public final QAbstractSimpleValueObject _super = new QAbstractSimpleValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    public final StringPath value = createString("value");

    public QUuidValueObject(String variable) {
        super(UuidValueObject.class,  forVariable(variable));
    }

    public QUuidValueObject(Path<? extends UuidValueObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUuidValueObject(PathMetadata<?> metadata) {
        super(UuidValueObject.class,  metadata);
    }

}

