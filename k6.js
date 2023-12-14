import http from 'k6/http';
import { check, sleep } from 'k6';
import { b64encode } from 'k6/encoding';

const BASE_URL = `http://${__ENV.ipToLoad}:8080`;

const USERNAME = 'oleh';
const PASSWORD = 'svt3';

export let options = {
  vus: 10,
  duration: '10m',
};

export default function () {
  let credentials = `${USERNAME}:${PASSWORD}`;
  let authHeaders = {
    Authorization: `Basic ${b64encode(credentials)}`,
  };

  let res = http.get(`${BASE_URL}/api/owner/`, {
    headers: authHeaders,
    rate:400
  });

  check(res, {
    'Status is 200': (r) => r.status === 200,
  });
}