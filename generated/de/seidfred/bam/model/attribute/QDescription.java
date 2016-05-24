package de.seidfred.bam.model.attribute;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDescription is a Querydsl query type for Description
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QDescription extends BeanPath<Description> {

    private static final long serialVersionUID = 1157715036L;

    public static final QDescription description = new QDescription("description");

    public final de.seidfred.bam.rdm.QStringValueObject _super = new de.seidfred.bam.rdm.QStringValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    //inherited
    public final StringPath value = _super.value;

    public QDescription(String variable) {
        super(Description.class,  forVariable(variable));
    }

    public QDescription(Path<? extends Description> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDescription(PathMetadata<?> metadata) {
        super(Description.class,  metadata);
    }

}

