package de.seidfred.bam.rdm;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QStringValueObject is a Querydsl query type for StringValueObject
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QStringValueObject extends BeanPath<StringValueObject> {

    private static final long serialVersionUID = 45632387L;

    public static final QStringValueObject stringValueObject = new QStringValueObject("stringValueObject");

    public final QAbstractSimpleValueObject _super = new QAbstractSimpleValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    public final StringPath value = createString("value");

    public QStringValueObject(String variable) {
        super(StringValueObject.class,  forVariable(variable));
    }

    public QStringValueObject(Path<? extends StringValueObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStringValueObject(PathMetadata<?> metadata) {
        super(StringValueObject.class,  metadata);
    }

}

