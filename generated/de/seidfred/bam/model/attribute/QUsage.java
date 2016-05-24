package de.seidfred.bam.model.attribute;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUsage is a Querydsl query type for Usage
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QUsage extends BeanPath<Usage> {

    private static final long serialVersionUID = 707663361L;

    public static final QUsage usage = new QUsage("usage");

    public final de.seidfred.bam.rdm.QStringValueObject _super = new de.seidfred.bam.rdm.QStringValueObject(this);

    //inherited
    public final BooleanPath nullOrEmpty = _super.nullOrEmpty;

    //inherited
    public final StringPath value = _super.value;

    public QUsage(String variable) {
        super(Usage.class,  forVariable(variable));
    }

    public QUsage(Path<? extends Usage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsage(PathMetadata<?> metadata) {
        super(Usage.class,  metadata);
    }

}

