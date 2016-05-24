package de.seidfred.bam.rdm;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDateValueObject is a Querydsl query type for DateValueObject
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QDateValueObject extends BeanPath<DateValueObject> {

    private static final long serialVersionUID = 259852486L;

    public static final QDateValueObject dateValueObject = new QDateValueObject("dateValueObject");

    public final QAbstractSimpleValueObject _super = new QAbstractSimpleValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    public final DatePath<java.util.Date> value = createDate("value", java.util.Date.class);

    public QDateValueObject(String variable) {
        super(DateValueObject.class,  forVariable(variable));
    }

    public QDateValueObject(Path<? extends DateValueObject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDateValueObject(PathMetadata<?> metadata) {
        super(DateValueObject.class,  metadata);
    }

}

