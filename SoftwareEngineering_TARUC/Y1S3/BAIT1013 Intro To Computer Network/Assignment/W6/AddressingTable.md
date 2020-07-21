# Packet Tracer - Verifying IPv4 and IPv6 Addressing

## Addresing Table

<table>
  <tr>
    <th rowspan="2">
      Device
    </th>
    <th rowspan="2">
      Interface
    </th>
    <th>
      IPv4 Address
    </th>
    <th>
      Subnet Mask
    </th>
    <th rowspan="2">
      Default Gateway
    </th>
  </tr>
  <tr>
    <th colspan="2">
      IPv6 Address/Prefix
    </th>
  </tr>
  <tr>
    <td rowspan="5">
      R1
    </td>
    <td rowspan="2">
      G0/0
    </td>
    <td>
      10.10.1.97
    </td>
    <td>
      255.255.255.224
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td colspan="2">
      2001:DB8:1:1::1/64
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td rowspan="2">
      S0/0/1
    </td>
    <td>
      10.10.1.6
    </td>
    <td>
      255.255.255.252
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td colspan="2">
      2001:DB8:1:2::2/64
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td>
      Link-local
    </td>
    <td colspan="2">
      FE80::1
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td rowspan="5">
      R2
    </td>
    <td rowspan="2">
      S0/0/0
    </td>
    <td>
      10.10.1.5
    </td>
    <td>
      255.255.255.252
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td colspan="2">
      2001:DB8:1:2::1/64
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td rowspan="2">
      S0/0/1
    </td>
    <td>
      10.10.1.9
    </td>
    <td>
      255.255.255.252
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td colspan="2">
      2001:DB8:1:3::1/64
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td>
      Link-local
    </td>
    <td colspan="2">
      FE80::2
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td rowspan="5">
      R3
    </td>
    <td rowspan="2">
      G0/0
    </td>
    <td>
      10.10.1.17
    </td>
    <td>
      255.255.255.240
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td colspan="2">
      2001:DB8:1:4::1/64
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td rowspan="2">
      S0/0/1
    </td>
    <td>
      10.10.1.10
    </td>
    <td>
      255.255.255.252
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td colspan="2">
      2001:DB8:1:3::2/64
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td>
      Link-local
    </td>
    <td colspan="2">
      FE80::3
    </td>
    <td>
      N/A
    </td>
  </tr>
  <tr>
    <td rowspan="2">
      PC1
    </td>
    <td rowspan="2">
      NIC
    </td>
    <td>
      10.10.1.100
    </td>
    <td>
      255.255.255.224
    </td>
    <td>
      10.10.1.97
    </td>
  </tr>
  <tr>
    <td colspan="2">
      2001:DB8:1:1::A/64
    </td>
    <td>
      FE80::1
    </td>
  </tr>
  <tr>
    <td rowspan="2">
      PC2
    </td>
    <td rowspan="2">
      NIC
    </td>
    <td>
      10.10.1.20
    </td>
    <td>
      255.255.255.240
    </td>
    <td>
      10.10.1.17
    </td>
  </tr>
  <tr>
    <td colspan="2">
      2001:DB8:1:4::A/64
    </td>
    <td>
      FE80::3
    </td>
  </tr>
</table>