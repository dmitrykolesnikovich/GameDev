package deet.ai;


import deet.math3D.PolygonGroup;
import deet.object.CollisionDetection;

public class EvolutionBot extends AIBot {

    private EvolutionGenePool genePool;
    private long damagedCaused;

    public EvolutionBot(PolygonGroup polygonGroup,
        CollisionDetection collisionDetection,
        EvolutionGenePool genePool, PolygonGroup blastModel)
    {
        super(polygonGroup, collisionDetection,
            genePool.getNewBrain(), blastModel);
        this.genePool = genePool;
        setRegenerating(true);
    }

    public void regenerate() {
        genePool.notifyDead(brain, damagedCaused);
        brain = genePool.getNewBrain();
        damagedCaused = 0;
        super.regenerate();
    }

    public void notifyHitPlayer(long damage) {
        damagedCaused+=damage;
    }
}
