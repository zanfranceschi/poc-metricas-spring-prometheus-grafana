# GRAFANA

docker:
```
docker run -d -p 3000:3000 grafana/grafana 
```


painel:
```json
{
  "aliasColors": {},
  "dashLength": 10,
  "datasource": "Prometheus",
  "fieldConfig": {
    "defaults": {},
    "overrides": []
  },
  "fill": 1,
  "gridPos": {
    "h": 8,
    "w": 12,
    "x": 0,
    "y": 0
  },
  "id": 23763571993,
  "legend": {
    "avg": false,
    "current": false,
    "max": false,
    "min": false,
    "show": true,
    "total": false,
    "values": false
  },
  "lines": true,
  "linewidth": 1,
  "nullPointMode": "null",
  "options": {
    "alertThreshold": true
  },
  "pluginVersion": "7.5.7",
  "pointradius": 2,
  "renderer": "flot",
  "seriesOverrides": [],
  "spaceLength": 10,
  "targets": [
    {
      "expr": "sum by (cliente_id) (floor(increase(requisicoes_clientes_total[5m])))",
      "legendFormat": "cliente 0{{cliente_id}}",
      "interval": "1m",
      "exemplar": true,
      "refId": "B",
      "hide": false
    }
  ],
  "thresholds": [],
  "timeRegions": [],
  "title": "requisicoes por clientes",
  "tooltip": {
    "shared": true,
    "sort": 0,
    "value_type": "individual"
  },
  "type": "graph",
  "xaxis": {
    "buckets": null,
    "mode": "time",
    "name": null,
    "show": true,
    "values": []
  },
  "yaxes": [
    {
      "format": "short",
      "label": null,
      "logBase": 1,
      "max": null,
      "min": null,
      "show": true
    },
    {
      "format": "short",
      "label": null,
      "logBase": 1,
      "max": null,
      "min": null,
      "show": true
    }
  ],
  "yaxis": {
    "align": false,
    "alignLevel": null
  },
  "description": "",
  "timeFrom": null,
  "timeShift": null,
  "bars": false,
  "dashes": false,
  "fillGradient": 0,
  "hiddenSeries": false,
  "percentage": false,
  "points": false,
  "stack": false,
  "steppedLine": false
}
```