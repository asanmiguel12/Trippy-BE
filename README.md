# Trippy-BE
Backend for Trippy Itinerary Planner

## Deployment on Render

This project uses Docker for deployment on Render. The `render.yaml` file is configured for Blueprint deployment.

### Important: Service Configuration

If you see errors like `yarn start` or `Couldn't find a package.json file`, it means Render is configured as a Node.js service instead of Docker.

**To fix:**
1. Go to your Render dashboard → Service Settings
2. Under "Build & Deploy", change Environment from "Node" to **"Docker"**
3. Set Dockerfile Path to `./Dockerfile`
4. Clear any Build Command and Start Command fields
5. Save and redeploy

Alternatively, delete the service and recreate it using Render Blueprint, which will automatically use the `render.yaml` configuration.
